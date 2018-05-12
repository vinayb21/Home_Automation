import mysql.connector

cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
print('connected')

cursor = cnx.cursor()
'''select status from room where roomID=1 AND deviceType=1;'''
'''add_cust = ("select status FROM room"
               "WHERE roomID is '1' AND deviceType is '1' "
               )
data_cust = (1, 1)'''
'''lightState=0
fanState=0'''
'''sql = "select status from room where roomID=1 AND deviceType=1"

cursor.execute(sql)
row=cursor.fetchall()
results = len(cursor.fetchall())
status = row[1]
'''
'''for row in results:
      lightState = row[0]'''
cursor.execute("SELECT status FROM room where roomID=1 AND deviceType=1")
for row in cursor:
  a=row
  
lightState=row[0]
cnx.commit()
'''lightState=status'''
cursor.close()
print(lightState)
print('inserted')

cnx.close()

