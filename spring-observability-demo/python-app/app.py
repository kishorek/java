from flask import Flask,request
from flask_zipkin import Zipkin
import os

app = Flask(__name__)

zipkin = Zipkin(app, sample_rate=100)
app.config['ZIPKIN_DSN'] = os.environ.get("zipkin_tracing_endpoint","http://127.0.0.1:9411/")+"api/v2/spans"

@app.route("/")
def hello_world():
    return "<p>Hello, from Python!</p>"

if __name__ == '__main__':
   app.run(host='0.0.0.0', debug=True)
