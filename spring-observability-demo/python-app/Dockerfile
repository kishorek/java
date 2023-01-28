FROM python:3.7-alpine

WORKDIR /app

RUN apk update && apk add python3-dev \
                        gcc \
                        libc-dev


COPY requirements.txt requirements.txt
RUN pip3 install -r requirements.txt

COPY . .

# CMD [ "python3", "-m" , "flask", "run", "--host=0.0.0.0"]
CMD ["python3","app.py"]
