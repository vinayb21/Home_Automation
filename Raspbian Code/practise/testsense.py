import time
import csv

x=0

#for i in range (0,51):
rows = [[x]]
    #name of csv file
filename = "testsenseCSV.csv"
    # writing to csv file
with open(filename, 'a') as csvfile:
        # creating a csv writer object
    csvwriter = csv.writer(csvfile)
        # writing the fields
        #csvwriter.writerow(fields)
        #writing the data rows
    csvwriter.writerows(rows)
    time.sleep(2)
    
print(x)
