������� ������� 213164 

Control Flow Graph
 

����������� ������������
������������� ������������ �� ����� � 10. �� ��������� ������ ��� ����� ���������� ����� ��� + 1(P+1) 9+1=10

Every branch
��� ������ 5 ���� ������ �� ��� �� �������� ���� ������:
���� 1: allItems � null
allItems = null, payment = 50
�������� "allItems list can't be null!"
�������� �� :if (allItems == null) - (1,2,3,21)
���� 2: allItems � ������ �����
allItems = [], payment = 100 true
 ��������: for (int i = 0; i < allItems.size(); i++), if (sum <= payment) - (4,5,18)
���� 3: ������� �� ��������� ������
allItems = [new Item("Item1", "12a45", 100, 0)], payment = 100
�������� "Invalid character in item barcode!"
��������: if (item.getName() == null || item.getName().length() == 0), item.setName("unknown"), if (item.getBarcode() != null), if (allowed.indexOf(c) == -1) - (6,7,9,12)
���� 4: ������� ��� ������ � ������� �� ������ � ������ �� ������� �� '0'
allItems = [new Item("Item1", null, 100, 0), new Item("Item2", "012345", 400, 0.1f)], payment = 100
�������� "No barcode!" (�������� �� �� ������� �� �������� �� �������� �� ������ �������)
��������: if (item.getBarcode() != null), else throw new RuntimeException("No barcode!"), if (item.getDiscount() > 0), sum += item.getPrice() * item.getDiscount(), if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'), sum -= 30 - (8,11,12,13,14,15,16)
���� ����� 5: ������� ��� ������
allItems = [new Item("Item1", "123456", 100, 0)], payment = 100
true
��������: if (item.getDiscount() > 0), sum += item.getPrice(), if (sum <= payment) - (13,18


���� 1 ������� �������� �� allItems == null.
���� 2 ������� ������ ����� � �������� �� if (sum <= payment) ���� ������ � 0.
���� 3 ������� �������� �� ��������� ������.
���� 4 ��������� �������� �� ������� ��� ������ � ������� �� ������ � ������ �� ������� �� '0'.
���� 5 ������� �������� �� ������� ��� ������ � �������� �� if (sum <= payment) ���� ������ � ������� �� ���������.



Multiple condition
��� 4 ����� ������ ��� ����� �� �� ������� �� Muiltiple condition.
���� 1 - ���� ������ �� ���������
item.getPrice() = 380, item.getDiscount() = 1, 
item.getBarcode() = "0784502060"
����� ��������: sum �� �������� �� 30
���� 2 - ������ � ������ ��� ������� �� 300
item.getPrice() = 300, item.getDiscount() = 1, 
item.getBarcode() = "0784502060"
����� ��������: sum �� ��������� �� item.getPrice() * item.getDiscount()
���� 3 - �������� � ����� ��� ������� �� 0
item.getPrice() = 380, item.getDiscount() = 0, item.getBarcode() = "0784502060"
����� ��������: sum �� ��������� �� item.getPrice()
���� 4 - �������� �� ��������� �� '0'
item.getPrice() = 380, item.getDiscount() = 1, item.getBarcode() = "7784502060"
����� ��������: sum �� ��������� �� item.getPrice() * item.getDiscount()

����������:
���� 1-���� ������ �� ���������, �� ����� sum �� ���� �������� �� 30
���� 2-������ �� item � ������ ��� ������� �� 300, �� �����  sum �� ��������� �� ������� �� ��������.
���� 3- �������� �� item � 0 ��� �����, �� ����� sum �� ��������� �� ������ �� item.
���� 4-�������� �� item �� ��������� �� '0', �� ����� sum  �� ��������� �� ������� �� ��������.

