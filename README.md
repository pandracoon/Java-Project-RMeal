# RMeal - 식당 리스트 관리 및 식당 추천 프로그램
고려대학교 컴퓨터학과 1학년 컴퓨터프로그래밍2 프로젝트   
Developer : 조재건

## 왜 만들어졌나?
식사할 때마다 무엇을 먹을지 고민하는 경우가 많습니다.  
이 프로그램을 개발한 저를 포함한 많은 사람들이 의외로 이 고민 때문에 식사 전에 많은 시간을 낭비합니다.  
막상 선택장애 해소 프로그램이라고 나와도 단순 랜덤 뽑기에 불과하다보니, 가기 싫은 식당이 추천되기도 합니다.  
RMeal은 식사를 고르기 귀찮은 모든 사람들을 위해 만들어졌습니다.

## 특징
* 식당 리스트 관리 시스템  
  * 자신이 자주 다니는 식당들을 저장, 수정, 삭제하면서 관리할 수 있습니다.
  * 식당을 특성 정보와 함께 저장합니다. (음식 타입, 가격, 식사 가능 인원, 위치)
  * 식당의 특성을 기준으로 한 유용한 검색 기능을 제공합니다.
* 식당 추천 시스템
  * 현재 나에게 맞는 식당을 추천해줍니다.
 
## 사용 방법
* 각 기능별 사용 방법은 아래 데모 영상을 통해 확인하실 수 있습니다.  
  (https://youtu.be/O4eDGuMeKN8)

* 검색 기능
  * 현재 사용자의 상황에 맞는 조건을 입력하면 검색할 수 있습니다.
  <이미지>
  * 식사, 가격대, 인원, 위치의 4가지 범주의 조건이 있고, 그 아래에 세부조건이 있습니다.
  * 식사는 음식의 종류를 의미합니다. 한식, 일식, 중식, 양식 외에는 기타로 체크합니다.
  * 인원은 식사 가능 인원을 의미합니다. 해당 인원이 식사 가능하다면 체크합니다.
  * 가격대는 대강의 음식의 가격대를 의미합니다. 10000원 미만은 5000원 이상 10000원 미만으로 간주하는 형식으로 생각합시다.
  * 위치는 음식점의 위치를 의미합니다. 위치는 사용자가 자유롭게 식당 추가 혹은 수정 페이지에서 설정할 수 있습니다.
  * 세부조건끼리는 OR형태로 조건을 검색하며, 아무것도 체크되지 않으면 전부 체크된 것으로 간주합니다.  
  EX) 한식, 일식이 동시에 체크되면 한식과 일식에 모두 해당하는 식당이 아닌, 한식과 일식중 하나라도 포함하는 식당을 검색
  * 4가지 범주끼리는 AND연산을 하며, 각 범주에서 아무것도 체크되지 않으면, 해당 범주를 검색 대상 조건에서 제외합니다.  
  EX) 식사에서 한식, 일식을 체크하고 인원에서 2인을 체크하면, 한식or일식을 포함하고 2인을 포함한 식당을 검색  
  
 > 나는 지금 친구 두명과 함께 있고, 저렴한 밥을 먹고싶으며(10000원 미만), 인문계 캠퍼스는 갈일이 없고, 중식과 양식은 먹고싶지 않다!
 >> 식사에서 한식, 일식, 기타 체크  
 >> 인원에서 2인 가능 체크  
 >> 가격대에서 5000원 미만, 10000원 미만 체크  
 >> 위치에서 참살이길, 옆살이길, 뒷살이길, 안암오거리, 이공계 캠퍼스 체크  
 >> 검색!

