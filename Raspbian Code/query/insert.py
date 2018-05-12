import mysql.connector

cnx = mysql.connector.connect(user='root', password='',host='localhost',database='mydb')
print('connected')

cursor = cnx.cursor()

add_cust = ("INSERT INTO customers "
               "(name, address) "
               "VALUES (%s, %s)")
data_cust = ('PQ Inc', 'Highway 87')

cursor.execute(add_cust,data_cust)

cnx.commit()

cursor.close()

print('inserted')

cnx.close()
