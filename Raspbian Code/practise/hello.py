import sys
# Takes first name and last name via command 
# line arguments and then display them
print("Output from Python")
print("First name: " + sys.argv[1])
print("Last name: " + sys.argv[2])
 
# save the script as hello.py

'''cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
print('connected')

cursor = cnx.cursor()

add_cust = ("INSERT INTO room "
               "(roomID, deviceType,deviceID,status) "
               "VALUES (%s, %s, %s, %s)")
data_cust = (sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4])

cursor.execute(add_cust,data_cust)

cnx.commit()

cursor.close()

print('inserted')

cnx.close()'''