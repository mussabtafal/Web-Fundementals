from flask import Flask, render_template 

app = Flask(__name__)
@app.route('/')                           
def checkBoard():
    return render_template('checker_board1.html', ver = 8, hor = 8 )

@app.route('/<x>')
def checkBoard1(x):
    return render_template("checker_board1.html", ver = int(x), hor = 8)	

@app.route('/<x>/<y>')
def checkBoard2(x, y):
    return render_template("checker_board1.html", ver = int(x), hor = int(y))	

@app.route('/<x>/<y>/<color1>/<color2>')
def checkBoard3(x, y, color1, color2):
    return render_template("checker_board1.html", ver = int(x), hor = int(y), some_color1 = color1, some_color2 = color2 )	


if __name__=="__main__":
    app.run(debug=True)
