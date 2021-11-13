# 1. 시작하기

1. `File > Settings > Build, Execution, Deployment > Build Tools > Gradle`에서 `Build and run using`, `Run tests using` 둘 다 `IntelliJ IDEA`
2. Annotation 오류 날 경우 `File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors`에서 Enable annoation processing 체크
3. gradle을 추가하고 반영이 안되면 오른쪽 사이드 Gradle 클릭 후 가장 상위 폴더에서 오른쪽 마우스 누르고 Refresh
4. 서버 실행 : src/main/java/damda/back/BackApplication에서 오른쪽 마우스 누르고 `Run`

## Aws 자격 증명 생성하기

1. [aws cli 설치](https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/install-cliv2-windows.html)

2. ```shell
   aws configure
   ```

3. 해당 값 입력

   ```shell
   AWS Access Key ID [None]:
   AWS Secret Access Key [None]: 
   Default region name [None]: 
   Default output format [None]: 
   ```

4. `C:\Users\사용자명\.aws`에서 `config` 및 `credentials` 파일에서 확인 가능



# 2. 서비스 생성

## 1. 파일 구조 및 역할



# 참고

## Postman

> API를 구축하고 사용하기 위한 API 플랫폼

* [사용 방법](https://velog.io/@ghtdjd2/postman%EC%9D%B4%EB%9E%80-%EC%82%AC%EC%9A%A9%EB%B2%95)
* post 요청시 `"error": "Unsupported Media Type"` 발생할 경우 Headers Content-Type `application/json`으로 설정

