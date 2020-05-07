import os
import secrets
from PIL import Image
from flask import render_template, url_for, request, flash, redirect
from StudentPortal import app, db, bcrypt
from StudentPortal.forms import RegistrationForm, LoginForm, UpdateForm
from StudentPortal.models import Student, StudentInfo, StudentResults, StudentDetails
from flask_login import login_user, current_user, logout_user, login_required

@app.route("/")
@app.route("/home")
def home():
    if current_user.is_authenticated:
        studentinfo=StudentInfo.query.filter_by(student_id=current_user.id).first()
        return render_template("index.html", studentinfo=studentinfo)
    return render_template("index.html")

@app.route("/register", methods=["POST", "GET"])
def register():
    return render_template("register.html")

@app.route("/login", methods=["POST", "GET"])
def login():
    if current_user.is_authenticated:
        return redirect(url_for('home'))
    form= LoginForm()
    if form.validate_on_submit():
        student=Student.query.filter_by(id=form.id.data).first()
        password=Student.query.filter_by(password=form.password.data).first()
        
        if (student and password):
            login_user(student, remember=form.remember.data)
            next_page=request.args.get('next')
            return redirect(next_page) if next_page else redirect(url_for('home'))
        else:
            flash("Login Unsuccessful! Please check ID or Password!", 'danger')
    
    return render_template("login.html", form=form)

@app.route("/logout", methods=["POST", "GET"])
def logout():
    logout_user()
    return redirect(url_for('home'))

def save_pic(form_pic):
    random_hex = secrets.token_hex(8)
    _, f_ext = os.path.splitext(form_pic.filename)
    picture_fn = random_hex + f_ext
    picture_path = os.path.join(app.root_path, 'static/profile_pics', picture_fn)

    output_size = (125, 125)
    i = Image.open(form_pic)
    i.thumbnail(output_size)
    i.save(picture_path)

    return picture_fn

@app.route("/account", methods=["POST", "GET"])
@login_required
def account():
    form=UpdateForm()
    image_file=url_for('static', filename='profile_pics/'+current_user.image_file)
    studentinfo=StudentInfo.query.filter_by(student_id=current_user.id).first()
    studentresult=StudentResults.query.filter_by(student_id=current_user.id).first()

    if form.validate_on_submit():
        if form.pic.data:
            picture_file=save_pic(form.pic.data)
            current_user.image_file= picture_file
        studentinfo.full_name=form.name.data
        studentinfo.email= form.email.data
        db.session.commit()
        flash("Account Updated!", 'success')
        return redirect(url_for('account'))
    elif request.method=="GET":
        form.name.data=studentinfo.full_name
        form.email.data=studentinfo.email
    return render_template("account.html", image_file=image_file, form=form, studentinfo=studentinfo, studentresult= studentresult)



@app.route("/results", methods=["POST", "GET"])
def results():
    if current_user.is_authenticated:
        studentinfo=StudentInfo.query.filter_by(student_id=current_user.id).first()
        studentresult=StudentResults.query.filter_by(student_id=current_user.id).first()
        return render_template("results.html", studentinfo=studentinfo, studentresult=studentresult)
    else:
        flash("Please log in to access the results page", "danger")
        return redirect(url_for('login'))

@app.route("/about", methods=["POST", "GET"])
def about():
    return render_template("about.html")

@app.route("/personal-information", methods=["POST","GET"])
def info():
    image_file=url_for('static', filename='profile_pics/'+current_user.image_file)
    studentinfo=StudentInfo.query.filter_by(student_id=current_user.id).first()
    studentresult=StudentResults.query.filter_by(student_id=current_user.id).first()
    details=StudentDetails.query.filter_by(student_id=current_user.id).first()
    return render_template("info.html", image_file=image_file, studentinfo=studentinfo, studentresult=studentresult, details= details)

@app.route("/admin-test", methods=["POST","GET"])
def admin():
    form= RegistrationForm()
    student1=Student(id=form.id.data, password=form.password.data)
    info=StudentInfo(full_name=form.name.data, course=form.course.data, email= form.email.data, advisor=form.advisor.data, phone_number=form.phone.data, module1=form.mod1.data, module2=form.mod2.data, module3=form.mod3.data, module4=form.mod4.data, student_id=student1.id)
    results= StudentResults(result1=form.result1.data, result2=form.result2.data, result3=form.result3.data, result4=form.result4.data, student_id=student1.id)
    details= StudentDetails(address=form.address.data, nationality=form.nationality.data, visa_status= form.visa_status.data, residence_type=form.residenceType.data, residence_location=form.residenceLocation.data, start_date=form.startDate.data, grad_date=form.endDate.data, study_mode=form.studyMode.data, student_id=student1.id)
    db.session.add(student1)
    db.session.add(results)
    db.session.add(info)
    db.session.add(details)
    db.session.commit()

    if form.validate_on_submit():
        flash(f"Student Name: {form.name.data} has been added", "success")

    return render_template("admin.html", form=form)
