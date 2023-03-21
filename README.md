### ControllerAdvice를 이용한 공통예외 처리 (발표용)

- 현황: 
  - 사용자(user), 게시물(post)를 관리하는 도메인이 존재한다.
  - 공통응답의 경우 CommonResponse의 표준을 따른다.
  - service 계층 구현은 생략한다.
  - 도메인 별 API 목록은 아래와 같다.
    - 사용자: 가입 / 조회 / 로그인 <br>
    - 게시글: 작성 / 조회 / 삭제 / 수정
     
- 요건:
  - 현재 유효성 / 조회 실패 시 공통적으로 예외처리를 하지않고 있다. 공통적으로 예외하는 영역을 @ControllerAdvice 이용하여 구현한다.
  - 엔티티 조회 실패 시 표준 예외를 throw 하고 있다. 예외의 명시성을 향상시키기 위해 NotFoundException 추가하고 공통 예외 처리를 한다.

- 요청샘플
> [User 등록] \
  curl -X POST http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"kim","email":"kim@naver.com"}' 
 
> [Post 등록] \
  curl -X POST http://localhost:8080/api/posts \
  -H 'Content-Type: application/json' \
  -d '{"title":"게시글","content":"게시글 내용"}' 

> [Post 조회] \
  curl -X GET http://localhost:8080/api/posts/1 \