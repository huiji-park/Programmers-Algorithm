String today //오늘 날짜 "YYYY.MM.DD"

2000 ≤ YYYY ≤ 2022
1 ≤ MM ≤ 12
1 ≤ DD ≤ 28

String[] terms //약관과 유효기간 "약관 종류 유효기간"

1 ≤ terms의 길이 ≤ 20
약관 종류는 A~Z
유효기간(달 수) 1 이상 100 이하

String[] privacies // 일자와 약관 종류 "날짜 약관 종류"

1 ≤ privacies의 길이 ≤ 100
--------------------------------------------input

today.replace(".", "-")
LocalDate today

Map<String, Integer>
put(terms.split(" ")[0], terms.split(" ")[1]);

for privacies 0부터 n까지
LocalDate day
Period() < map.get()
---------------------------------------------output
int[] answer //파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열