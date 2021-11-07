This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Getting Started

실행 하는 법:

> package manager로는 [yarn](https://yarnpkg.com/)을 사용합니다.

```bash
yarn install # package 설치

yarn dev # 개발모드로 실행
```

[http://localhost:3000](http://localhost:3000) 로 접속하면 화면을 확인할 수 있습니다.

> port를 바꿔주고 싶다면 `yarn dev -p 4000` ([http://localhost:4000](http://localhost:4000)) 와 같이 변경이 가능합니다. 



## Create next app

[Next.js로 React project 생성하기](https://nextjs.org/docs/getting-started)

```bash
yarn create next-app --typescript
```

개발 언어로는 typescript를 사용하므로 `--typescript` 를 추가해줍니다.



## 외부 라이브러리

### next-pwa

[참고](https://www.npmjs.com/package/next-pwa)

#### install

```bash
yarn add next-pwa
```

#### 사용법

1. WithPWA

   [`next.config.js`](./next.config.js) 파일 수정

   ```js
   const withPWA = require('next-pwa')
   
   module.exports = withPWA({
     // other next config
   })
   ```

2. Manifest File 생성

   간편하게 생성해주는 사이트 : [simicart - manifest-generator](https://www.simicart.com/manifest-generator.html/)

   ```json
   {
     "name": "PWA App",
     "short_name": "App",
     "icons": [
       {
         "src": "/icons/android-chrome-192x192.png",
         "sizes": "192x192",
         "type": "image/png",
         "purpose": "any maskable"
       },
       {
         "src": "/icons/android-chrome-384x384.png",
         "sizes": "384x384",
         "type": "image/png"
       },
       {
         "src": "/icons/icon-512x512.png",
         "sizes": "512x512",
         "type": "image/png"
       }
     ],
     "theme_color": "#FFFFFF",
     "background_color": "#FFFFFF",
     "start_url": "/",
     "display": "standalone",
     "orientation": "portrait"
   }
   ```

3. Meta 태그 추가

   `/pages/_app.ts` 와 같은 directory 위치에 `_document.ts` 생성