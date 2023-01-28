from flask import Flask,request
from flask_zipkin import Zipkin

app = Flask(__name__)

zipkin = Zipkin(app, sample_rate=100)
app.config['ZIPKIN_DSN'] = "http://127.0.0.1:9411/api/v2/spans"


@app.route("/")
def hello_world():
    # print(request.headers)
    return "<p>Hello, from Python!</p>"

if __name__ == '__main__':
   app.run()
