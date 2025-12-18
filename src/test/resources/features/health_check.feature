Feature: 시스템 상태 확인
  Scenario: 시스템의 상태를 확인한다.
    When GET /health API를 요청하면
    Then 응답 상태 코드는 200 이어야 한다.
    And 응답 본문은 "OK" 이어야 한다.