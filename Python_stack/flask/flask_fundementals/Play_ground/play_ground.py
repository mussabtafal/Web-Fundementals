from flask import Flask, render_template 

app = Flask(__name__)
@app.route('/')                           
def boxhtml():
    return render_template('play_ground1.html')  

@app.route('/play/<times>')
def boxRepeat(times):
    return render_template("play_ground2.html", some_num = int(times))	

@app.route('/play/<times>/<color>')
def boxRepeatColor(times, color):
    return render_template("play_ground3.html", some_num = int(times), some_color = color)	

if __name__=="__main__":
    app.run(debug=True)                   
