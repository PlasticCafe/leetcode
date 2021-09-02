class Solution:
    romanTable =[(1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'), (100, 'C'),
     (90, 'XC'), (50, 'L'), (40, 'XL'), (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')]
    def intToRoman(self, num:int) -> str:
        roman = []
        tableEntry = 0
        counter = 0
        while num > 0:
            if(self.romanTable[tableEntry][0] <= num):
                num = num - self.romanTable[tableEntry][0]
                roman.append(self.romanTable[tableEntry][1])
                counter = counter + 1
            else:
                if(tableEntry < len(self.romanTable) - 1):
                    tableEntry = tableEntry + 1                    
        return ''.join(roman)
                
