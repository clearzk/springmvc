document.addEventListener("DOMContentLoaded",function(){

    var para = document.querySelector('p');

    para.addEventListener('click', updateName);

    function updateName() {
        var name = prompt('Enter a new name');
        para.textContent = 'Player 1: ' + name;
    }

    function createParagraph() {
        var para = document.createElement('div');
        para.textContent = 'You clicked the button!';
        document.body.appendChild(para);
    }

    var buttons = document.querySelectorAll('button');

    for(var i = 0; i < buttons.length ; i++) {
        buttons[i].addEventListener('click', createParagraph);
    }
});