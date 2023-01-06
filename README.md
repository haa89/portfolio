# 프로젝트
- 프로젝트 명 : 영단어 게임
- 개발 기간 : 2022년 7월 12일 ~ 2022년 7월 14일
- 개발 인원 : 5명

### 개발목표
- MVC패턴을 활용해 간단한 프로그램 제작

### 개발내용
- 회원가입 및 로그인
- 게임화면
   - 난이도 선택
   - 게임 플레이 화면
- 랭킹
- 오답노트 
***


## 1. 기술 및 도구
<img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"><img src="https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=Eclipse%20IDE&logoColor=white">
## 2. ER Diagram
![ERD](https://user-images.githubusercontent.com/107980297/211022209-54dbd6d2-dbdc-43bb-9ff4-556910293b2e.jpg)
## 3. 서비스 흐름도
![흐름도](https://user-images.githubusercontent.com/107980297/211022202-416ad6ed-f575-4663-a397-f54a0e43b2f3.jpg)
## 4. 구현
- 메인화면
![word1](https://user-images.githubusercontent.com/107980297/211022777-f8037891-22b2-418a-9b52-4547da8f6252.png)
회원가입 및 로그인

- 게임 플레이
![word2](https://user-images.githubusercontent.com/107980297/211022783-a1e911df-4c42-4c17-a1f7-1d7055cddd31.png)
데이터베이스에서 랜덤으로 문제와 답 불러오고 오답도 랜덤으로 불러오는 알고리즘 구현
점수는 연속으로 맞출경우 추가 점수부여하는 알고리즘 구현
문제를 틀리면 목숨 하나를 차감하고 오답노트에 틀린문제 전송

- 랭킹
![word3](https://user-images.githubusercontent.com/107980297/211022788-0d73b920-5098-4535-a3f6-fffbca1d3b11.png)
랭킹 시스템 구현

- 오답노트
![word4](https://user-images.githubusercontent.com/107980297/211022790-64a1bed3-c0e2-497a-ad7f-f9ddd86a8199.png)
틀렸던 문제 오답노트 형식으로 불러오는 알고리즘 구현
