import mysql.connector

def updateDB(lightStatus, fanStatus):

    cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
    print('connected')

    cursor = cnx.cursor()

    query1 = ("UPDATE room SET status= "+lightStatus+" WHERE roomID=2 AND deviceType=1")
    query2 = ("UPDATE room SET status= "+fanStatus+" WHERE roomID=2 AND deviceType=2")
    

    cursor.execute(query1)
    cursor.execute(query2)

    cnx.commit()

    cursor.close()

    print('updated')

    cnx.close()

