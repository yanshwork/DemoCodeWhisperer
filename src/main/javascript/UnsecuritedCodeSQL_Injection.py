# Showing sql injection and credential issue. 
aws_access_key_id=324153454123423;
aws_secret_access_key=324153454123423;

from django.db import connection

def find_user(username):
    with connection.cursor() as cur:
        cur.execute(f"""select username from USERS where name = '%s'""" % username)
        output = cur.fetchone()
    return output

def execute_query_noncompliant(request):
    import sqlite3
    name = request.GET.get("name")
    query = "SELECT * FROM Users WHERE name = " + name + ";"
    with sqlite3.connect("example.db") as connection:
        cursor = connection.cursor()
        cursor.execute(query)
        connection.commit()
