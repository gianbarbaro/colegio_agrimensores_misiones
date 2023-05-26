/* efecto scroll en el header */
const nav = document.querySelector('header');

window.addEventListener('scroll', function(){
    nav.classList.toggle('active', this.window.scrollY > 0)
})

/* navbar resposive */
const barraMenu = document.getElementById('barra-menu');
const navMenu = document.getElementById('nav-menu');

barraMenu.addEventListener('click', function(){
    navMenu.classList.toggle('nav-menu_show')
})