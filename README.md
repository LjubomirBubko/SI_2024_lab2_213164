Љубомир Николов 213164 

Control Flow Graph
 ![CFG drawio](https://github.com/LjubomirBubko/SI_2024_lab2_213164/assets/162362247/d0a74e51-e052-4536-b88b-d756729fce2e)


___________________________________________________________________________________________________________________________
Цикломатска комплексност

Цикломатската комплексност на кодот е 10. Ја пресметав според тоа колку предикатни јазли има + 1(P+1) 9+1=10
___________________________________________________________________________________________________________________________
Every branch

Има вкупно 5 тест случаи со кои се опфаќаат сите гранки:

Тест 1: allItems е null                     
         allItems = null, payment = 50                   
         Исклучок "allItems list can't be null!"              
         Опфатено до :if (allItems == null) - (1,2,3,21)
         
Тест 2: allItems е празна листа                                
          allItems = [], payment = 100 true                                            
          Опфатено: for (int i = 0; i < allItems.size(); i++), if (sum <= payment) - (4,5,18) 
          
Тест 3: Предмет со невалиден баркод                                   
          allItems = [new Item("Item1", "12a45", 100, 0)], payment = 100                                          
          Исклучок "Invalid character in item barcode!"                                            
          Опфатено: if (item.getName() == null || item.getName().length() == 0), item.setName("unknown"), if (item.getBarcode() != null), if (allowed.indexOf(c) == -1) - (6,7,9,12)
          
Тест 4: Предмет без баркод и предмет со попуст и баркод кој почнува со '0'                                                
         allItems = [new Item("Item1", null, 100, 0), new Item("Item2", "012345", 400, 0.1f)], payment = 100                                                      
         Исклучок "No barcode!" (Методата ќе се прекине по фрлањето на исклучок за првиот предмет)                                                
         Опфатено: if (item.getBarcode() != null), else throw new RuntimeException("No barcode!"), if (item.getDiscount() > 0), sum += item.getPrice() * item.getDiscount(), if (item.getPrice() > 300 && 
         item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'), sum -= 30 - (8,11,12,13,14,15,16)
         
Тест случај 5: Предмет без попуст                       
         allItems = [new Item("Item1", "123456", 100, 0)], payment = 100                           
         true                                   
         Опфатено: if (item.getDiscount() > 0), sum += item.getPrice(), if (sum <= payment) - (13,18,20)                                        


Тест 1 покрива проверка за allItems == null.                                   
Тест 2 покрива празна листа и проверка за if (sum <= payment) кога сумата е 0.                                 
Тест 3 покрива проверка за невалиден баркод.                                       
Тест 4 комбинира проверка за предмет без баркод и предмет со попуст и баркод кој почнува со '0'.                                            
Тест 5 покрива проверка за предмет без попуст и проверка за if (sum <= payment) кога сумата е еднаква на плаќањето.                                          

__________________________________________________________________________________________________________________________________

Multiple condition

Има 4 можни случаи кои треба да се опфатат со Muiltiple condition.

Тест 1 - Сите услови се исполнети                               
         item.getPrice() = 380, item.getDiscount() = 1,                             
         item.getBarcode() = "0123456789"                                       
         краен резултат: sum се намалува за 30                                  
Тест 2 - Цената е помала или еднаква на 300                                 
         item.getPrice() = 300, item.getDiscount() = 1,                                            
         item.getBarcode() = "0123456789"                                         
         краен резултат: sum се зголемува за item.getPrice() * item.getDiscount()                                  
Тест 3 - Попустот е помал или еднаков на 0                                                 
         item.getPrice() = 380, item.getDiscount() = 0, item.getBarcode() = "0123456789"                                                 
         краен резултат: sum се зголемува за item.getPrice()                                                       
Тест 4 - Баркодот не започнува со '0'                                              
         item.getPrice() = 380, item.getDiscount() = 1, item.getBarcode() = "1123456789"                                  
         краен резултат: sum се зголемува за item.getPrice() * item.getDiscount()                         
                                      
Објаснување:                                                 
Тест 1-Сите услови се исполнети, па затоа sum ќе биде намалена за 30                                               
Тест 2-Цената на item е помала или еднаква на 300, па затоа  sum се зголемува за износот на попустот.                                   
Тест 3- Попустот на item е 0 или помал, па затоа sum се зголемува за цената на item.                                      
Тест 4-Баркодот на item не започнува со '0', па затоа sum  се зголемува за износот на попустот.                                               

