// JavaScript 코드
document.addEventListener('DOMContentLoaded', function() {
    const navLinks = document.querySelectorAll('nav a');
    const sections = document.querySelectorAll('.section');
    const passwordModal = document.getElementById('password-modal');
    const editProfileBtn = document.getElementById('edit-profile-btn');
    const confirmPasswordBtn = document.getElementById('confirm-password-btn');
    const closeModal = document.querySelector('.close');
    const profileForm = document.getElementById('profile-form');

    // 모든 섹션 숨기기
    sections.forEach(section => {
        section.style.display = 'none';
    });

    // 기본적으로 첫 번째 섹션만 보이기
    sections[0].style.display = 'block';

    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault(); // 기본 링크 동작 방지
            const targetId = this.getAttribute('href').substring(1); // href에서 # 제거
            sections.forEach(section => {
                section.style.display = 'none'; // 모든 섹션 숨기기
            });
            document.getElementById(targetId).style.display = 'block'; // 선택한 섹션만 보이기
        });
    });

    // 회원 정보 수정 버튼 클릭 시 비밀번호 모달 열기
    editProfileBtn.addEventListener('click', function() {
        passwordModal.style.display = 'block';
    });

    // 비밀번호 확인 버튼 클릭 시
    confirmPasswordBtn.addEventListener('click', function() {
        const enteredPassword = document.getElementById('password').value;
        const correctPassword = 'yourActualPassword'; // 로그인된 사용자의 비밀번호 (예시)

        if (enteredPassword === correctPassword) {
            passwordModal.style.display = 'none';
            profileForm.style.display = 'block'; // 비밀번호가 일치하면 폼 보이기
        } else {
            alert('비밀번호가 일치하지 않습니다.'); // 비밀번호 불일치 시 경고
        }
    });

    // 모달 닫기
    closeModal.addEventListener('click', function() {
        passwordModal.style.display = 'none';
    });

    // 모달 외부 클릭 시 닫기
    window.addEventListener('click', function(event) {
        if (event.target === passwordModal) {
            passwordModal.style.display = 'none';
        }
    });
});