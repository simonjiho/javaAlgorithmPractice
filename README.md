# javaAlgorithmPractice

알고리즘 문제를 Java로 푼 코드를 모은 Eclipse 프로젝트다. 2025-08-07부터 2025-09-12까지 커밋했다.

## 구성

- `src/Boj_<번호>.java`: 백준 문제 풀이 8개 (3190, 15989, 17779, 17822, 17825, 17837, 19236, 20061)
- `src/SWExpert_<번호>.java`: SW Expert Academy 문제 풀이 47개. 번호 뒤에 `_1`이 붙은 파일이 5쌍(1221, 1226, 1251, 1767, 1861) 있다. 같은 번호의 두 파일은 내용이 서로 다르다
- `src/Solution.java`, `src/UserSolution.java`: 입력 처리 틀과 구현을 나눈 형식의 문제. `Solution.java`가 명령(`init`, `hire`, `fire`, `updateSoldier`, `updateTeam`, `bestSoldier`)을 읽어 `UserSolution.java`의 메서드를 부른다. 병사 고용·해고, 점수 갱신, 팀별 최고 병사 조회는 `UserSolution.java`에 있다
- `bin/`: 컴파일된 `.class` 파일
- `.project`, `.classpath`: Eclipse 프로젝트 설정 (소스 `src`, 출력 `bin`)

Boj 파일 몇 개에는 풀이 시작 시각이, 일부에는 검색한 내용이 주석으로 남아 있다.

## 실행

패키지 선언 없이 `src`에 모두 들어 있다. 문제 파일은 각자 `main`이 있고 표준 입력에서 입력을 읽는다. Eclipse로 프로젝트를 불러와 파일 하나씩 실행한다. `Solution.java`는 첫 줄에 테스트 수와 배점을 받는다.
