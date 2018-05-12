import mysql.connector


def light():
    cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
    print('connected')

    cursor = cnx.cursor()

    cursor.execute("SELECT status FROM room where roomID=1 AND deviceType=1")
    for row in cursor:
      a=row
  
    lightState=row[0]
    cnx.commit()

    cursor.close()
    print(lightState)
    print('inserted')

    cnx.close()

    return (lightState)


