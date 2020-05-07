from datetime import datetime
from StudentPortal import db, login_manager
from flask_login import UserMixin, current_user



@login_manager.user_loader
def load_user(user_id):
    return Student.query.get(int(user_id))

class Student(db.Model, UserMixin):
    __tablename__="student"
    id = db.Column(db.Integer, primary_key=True)
    password=db.Column(db.String(60))
    image_file= db.Column(db.String(60), default="default.jpg")
    info = db.relationship("StudentInfo", backref='student_name', lazy=True)
    results= db.relationship('StudentResults', backref='student_results', lazy=True)

    def __repr__(self):
        return (f"Student('{self.id}','{self.image_file}')")

class StudentInfo(db.Model, UserMixin):
    __tablename__="studentinfo"
    id = db.Column(db.Integer, primary_key=True)
    full_name= db.Column(db.String(60))
    course = db.Column(db.String(60))
    email=db.Column(db.String(60))
    advisor = db.Column(db.String(60))
    phone_number= db.Column(db.Integer)
    module1 = db.Column(db.String(60))
    module2 = db.Column(db.String(60))
    module3 = db.Column(db.String(60))
    module4 = db.Column(db.String(60))
    student_id= db.Column(db.Integer, db.ForeignKey('student.id'))

    def __repr__(self):
        return (f"StudentInfo('{self.id}','{self.full_name}')")

class StudentResults(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    result1= db.Column(db.Integer)
    result2= db.Column(db.Integer)
    result3= db.Column(db.Integer)
    result4= db.Column(db.Integer)
    gpa= db.Column(db.String(60))
    student_id= db.Column(db.Integer, db.ForeignKey('student.id'))

    def __repr__(self):
        return (f"StudentResults('{self.id}','{self.gpa}')")

class StudentDetails(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    address= db.Column(db.String(200))
    nationality = db.Column(db.String(60))
    visa_status= db.Column(db.String(100))
    residence_type= db.Column(db.String(60))
    residence_location = db.Column(db.String(60))
    start_date= db.Column(db.String(60))
    grad_date= db.Column(db.String(60))
    study_mode= db.Column(db.String(60))
    student_id= db.Column(db.Integer, db.ForeignKey('student.id'))

    def __repr__(self):
        return (f"StudentDetails('{self.id}','{self.address}')")