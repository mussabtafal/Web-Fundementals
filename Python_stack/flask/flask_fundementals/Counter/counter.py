from flask import Flask, render_template, redirect, request, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe' 

@app.route('/')
def create_counter():
    print("Got Post Info")
    if not "counter" in session:
        session['counter'] = 0
    else:
        session['counter'] += 1

    if 'counter' in session:
        print('key exists!')
    else:
        print("key 'key_name' does NOT exist")
    if not "actual_counter" in session:
        session['actual_counter'] = 0
    else:
        session['actual_counter'] += 1
    return render_template("counter.html")

@app.route('/destroy_session')
def delete_counter():
    session.clear()		# clears all keys
    return redirect('/')

@app.route('/plus2')
def addtwoVisits():
    print("Got Post Info")
    session['counter'] += 1
    return redirect("/")

@app.route('/random', methods=['POST'])
def addrandom():
    print("Got Post Info")
    session['counter'] += int(request.form["random_counter"]) - 1
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)
