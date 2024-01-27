import PyPDF2
import xlwt
import os
import xlrd
import re

folder = "pdfs"

for filename in os.listdir(folder):

    testname = os.path.join(folder, filename)
    pdf_file = PyPDF2.PdfReader(open(testname, "rb"))
    text = ""
    for i in range(0, len(pdf_file.pages)):
        text += pdf_file.pages[i].extract_text()

    # text into lines one by one
    lines = text.split("\n")

    #loop thru lines
    questions = [] #all questions
    question = [] #current question
    for line in lines:
        line = line.strip()
        if "Copyright" in line and "by" in line:
            q = line.split("1.")[1] #makes sure there's no empty cell in A1 after the split instead of directly appending it
            question.append("1." + q)
        elif line.startswith(tuple([str(i) + "." for i in range(1, 101)])): #check if line starts with a number between 1 and 100 followed by a period
            if question:
                questions.append(question)
            question = [line]
        elif "EXAM" in line and "Test" in line:
            question.append(line.split("Test")[0])
        elif line.startswith(("A.", "B.", "C.", "D.")):
            question.append(line)
        else:
            question.append(line)

    # Handle answer choices on the same line
    for i, question in enumerate(questions):
        new_question = []
        for line in question:
            if "A." in line and "C." in line:
                new_question.append(line.split("C.")[0])
                new_question.append("C." + line.split("C.")[1])
            elif "B." in line and "D." in line:
                new_question.append(line.split("D.")[0])
                new_question.append("D." + line.split("D.")[1])
            else:
                new_question.append(line)
        questions[i] = new_question


    # essentially removes all leading blank cells in row A
    while (questions[0][0] == ""):
        for i in range(0, len(questions[0]) - 1):
            questions[0][i] = questions[0][i + 1]
        questions[0][len(questions[0]) - 1] = ""  # removes the extra copy of answer choice D


    # gets rid of all extra information after the category of each question in the answer key
    for i in range(100,199):
        j = len(questions[i])-1
        while "SOURCE" not in questions[i][j]:
            questions[i][j] = ""
            j-=1
        if ("SOURCE" in questions[i][j] and "SOURCE" in questions[i][j - 1]):
            questions[i][j] = ""


    # Store the questions and answer choices in an excel sheet
    book = xlwt.Workbook(encoding="utf-8")
    sheet = book.add_sheet("Test Questions", cell_overwrite_ok=True)

    for i, question in enumerate(questions):
        for j, line in enumerate(question):
            sheet.write(i, j, line)

    for col in range(len(questions[99])):  # removes Q100 because answer key is also missing Q100
        sheet.write(99,col,"")


    sheetname = testname.replace(".pdf", ".xls")

    book.save(sheetname)


