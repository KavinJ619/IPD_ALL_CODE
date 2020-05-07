from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileAllowed
from flask_login import current_user
from wtforms import StringField, PasswordField, SubmitField, BooleanField, IntegerField
from wtforms.validators import DataRequired, Length, Email, EqualTo, ValidationError

class RegistrationForm(FlaskForm):
    id=StringField("Student ID", validators=[DataRequired(), Length(min=2, max=50)])
    name= StringField('Full Name', validators=[DataRequired(), Length(min=2, max=50)])
    email= StringField('Email', validators=[DataRequired(), Length(min=2, max=50), Email()])
    course = StringField('Course', validators=[DataRequired(), Length(min=2, max=50)])
    advisor = StringField('Advisor', validators=[DataRequired(), Length(min=2, max=50)])
    phone= StringField('Phone Number', validators=[DataRequired(), Length(min=2, max=50)])
    mod1= StringField('Module 1', validators=[DataRequired(), Length(min=2, max=50)])
    mod2= StringField('Module 2', validators=[DataRequired(), Length(min=2, max=50)])
    mod3= StringField('Module 3', validators=[DataRequired(), Length(min=2, max=50)])
    mod4= StringField('Module 4', validators=[DataRequired(), Length(min=2, max=50)])
    result1= StringField('Result 1', validators=[DataRequired(), Length(min=2, max=50)])
    result2= StringField('Result 2', validators=[DataRequired(), Length(min=2, max=50)])
    result3= StringField('Result 3', validators=[DataRequired(), Length(min=2, max=50)])
    result4= StringField('Result 4', validators=[DataRequired(), Length(min=2, max=50)])
    gpa= StringField('GPA', validators=[DataRequired(), Length(min=2, max=50)])
    password=PasswordField('Password', validators=[DataRequired()])
    confirm_password=PasswordField('Confirm Password', validators=[DataRequired(), EqualTo('password')])
    address = StringField('Address', validators=[DataRequired(), Length(min=2, max=200)])
    nationality = StringField('Nationality', validators=[DataRequired(), Length(min=2, max=80)])
    visa_status=StringField('Visa Status', validators=[DataRequired(), Length(min=2, max=100)])
    residenceType = StringField('Residence Type', validators=[DataRequired(), Length(min=2, max=100)])
    residenceLocation = StringField('Residence Location', validators=[DataRequired(), Length(min=2, max=100)])
    startDate = StringField('Start Date', validators=[DataRequired(), Length(min=2, max=100)])
    endDate= StringField('Graduation Date', validators=[DataRequired(), Length(min=2, max=100)])
    studyMode = StringField('Study Mode', validators=[DataRequired(), Length(min=2, max=100)])
    submit= SubmitField("Sign Up")

class LoginForm(FlaskForm):
    id= StringField('Student ID', validators=[DataRequired(), Length(min=2, max=50)])
    password=PasswordField('Password', validators=[DataRequired()])
    remember= BooleanField('Remember me')
    submit = SubmitField('Log in')

class UpdateForm(FlaskForm):
    name=StringField("Name", validators=[DataRequired(), Length(min=2, max=60)])
    email= StringField("Email", validators=[DataRequired(), Email()])
    pic=FileField("Update Profile Picture", validators=[FileAllowed(['jpg', 'png', 'jpeg'])])
    submit=SubmitField("Update")

class AdminLoginForm(FlaskForm):
    id= StringField('Admin ID', validators=[DataRequired(), Length(min=2, max=50)])
    password=PasswordField('Password', validators=[DataRequired()])
    remember= BooleanField('Remember me')
    submit = SubmitField('Log in')