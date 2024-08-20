<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
        integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        clifford: '#da373d',
                        // login: '#FFCEFF'
                    }
                }
            }
        }
    </script>
    <style>
    </style>
</head>

<body>
<form action="signUp.jsp" method="post">
    <div class="container mx-auto flex flex-col h-screen">
        <div class="flex py-2 space-x-3 border border-gray-200 border-b-0">
            <div class="pl-3">
                <i class="fa-sharp-duotone fa-solid fa-bell text-xl"></i>
            </div>
            <div>
                <i class="fa-sharp-duotone fa-solid fa-barcode text-xl"></i>
            </div>
            <div class="flex-1 flex justify-center cursor-pointer">
                <span class="rounded-full p-4 hover:bg-gray-100">
                    <i class="fa-sharp-duotone fa-solid fa-mug-hot text-5xl"></i>
                </span>
            </div>
            <div>
                <i class="fa-sharp-duotone fa-solid fa-magnifying-glass text-xl"></i>
            </div>
            <div class="pr-3">
                <i class="fa-sharp-duotone fa-solid fa-cart-shopping text-xl"></i>
            </div>
        </div>
        <div class="border border-gray-200 py-3 border-t-0">
            <ul class="flex justify-around text-xl">
                <li>커피</li>
                <li>에이드</li>
                <li>스무디</li>
                <li>티</li>
                <li>디저트</li>
                <li>MD</li>
            </ul>
        </div>
        <div class="flex-1 flex flex-col bg-gray-200 items-center justify-center">
            <div class="flex mb-10">
                <div class="flex flex-col w-80 space-y-2 mr-2">
                    <input type="text" name="email" id="" placeholder="아이디" 
                        class="focus:outline-none px-2 rounded text-xl">
                    <input type="text" name="password" id="" placeholder="비밀번호" 
                        class="focus:outline-none px-2 rounded text-xl">
                </div>
                <div class="bg-blue-500 px-5 py-4 rounded text-2xl">
                    <button>회원가입</button>
                </div>
            </div>
            <div>
                <div>
                    <input type="checkbox" name="" id="">
                    <label>아이디저장하기</label>
                    <input type="checkbox" name="" id="">
                    <label>자동 로그인</label>
                </div>
            </div>
            <div class="relative w-96 text-center mt-10">
                <div class="border border-t-1 border-gray-400 absolute top-3 w-24"></div>
                간편하게 로그인하세요
                <div class="border border-t-1 border-gray-400 absolute right-0 top-3 w-24"></div>
            </div>
            <div class="flex space-x-3 mt-10">
                <a href=""><img src="kakao.png" alt="카카오"></a>
                <a href=""><img src="naver.png" alt="네이버"></a>
                <a href=""><img src="google.png" alt="구글"></a>
            </div>
            <div class="relative w-96 text-center mt-10">
                <h1 class="text-2xl mb-2">회원가입하고 적립금 5,000원 받자!</h1>
                <h1><span>아이디 찾기</span> / <span>비밀번호 찾기</span></h1>
            </div>
        </div>
        <div class="border border-gray-200 py-3 border-t-0">
            <ul class="flex justify-around text-xl">
                <li class="flex flex-col items-center">
                    <i class="fa-sharp-duotone fa-solid fa-house"></i>
                    <span>HOME</span>
                </li>
                <li class="flex flex-col items-center">
                    <i class="fa-solid fa-hand-point-up"></i>
                    <span>ORDER</span>
                </li>
                <li class="flex flex-col items-center">
                    <i class="fa-solid fa-wand-sparkles"></i>
                    <span>EVENT</span>
                </li>
                <li class="flex flex-col items-center">
                    <i class="fa-solid fa-user"></i>
                    <span>MYPAGE</span>
                </li>
            </ul>
        </div>
    </div>
</form>
</body>

</html>