import xlsxwriter
import os
 
 
data = [
	[1, 2, "a", "good", "excellent"],
	[4, 3, "Excel"]
	]
 
def insert_data(listdata):
	wb = xlsxwriter.Workbook("Excel1.xlsx")
	ws = wb.add_worksheet()
	row = 0
	col = 0
	for line in listdata:
		for item in line:
			ws.write(row, col, item)
			col += 1
		row += 1
		col = 0
 
	wb.close()
 
insert_data(data)
os.system("Excel1.xlsx")