import pandas as pd
import openpyxl


def print_hi():
    xl = pd.ExcelFile("data.xlsx")
    print(xl.sheet_names)
    i = 0
    for sheet in xl.sheet_names:
 
        if i < 14:
            i += 1
            continue
        i += 1
        if i > 18: return
        df_sheet_index = pd.read_excel('data.xlsx', sheet_name=sheet, usecols='D:F', skiprows=5)
        print(f'{sheet}')
        print("==========================================")
        for index, row in df_sheet_index[0:].iterrows():
            print(10 - row[1])

            if row[0] != row[0] or row[1] != row[1] or row[2] != row[2]:
                continue
            # print(f'{int(row[0])}: {row[2]}')
            # print(f'{int(row[0])}: {row[2]}')
            if (int(10 - row[1]) == 0):
                print(f'{int(row[0])}: {row[2]}')
                print("------------------------------------------")
            else:
                print(f'{int(row[0])}: (-{int(10 - row[1])}) {row[2]}')
                print("------------------------------------------")


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
