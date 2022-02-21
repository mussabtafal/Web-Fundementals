from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' # set a secret key for security purposes
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def create_user():
    print("Got Post Info")
    print(request.form)
    # Here we add two properties to session to store the name and email
    name_from_form = request.form['name']
    location_from_form = request.form['location']
    language_from_form = request.form['language']
    gender_from_form = request.form['gender']
    accept_from_form = request.form['accept']
    comment_from_form = request.form['comment']
    return render_template("show.html", name_on_template = name_from_form, location_on_template = location_from_form,
    language_on_template = language_from_form, gender_on_template = gender_from_form,
    accept_on_template = accept_from_form, comment_on_template = comment_from_form )

if __name__ == "__main__":
    app.run(debug=True)

