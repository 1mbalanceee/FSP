const $continuebot = document.querySelector('.continuebot')
const $head1 = document.querySelector('#head1')
const $parsebody = document.querySelector('.parsebody')
const $parsesurvey = document.querySelector('.parsesurvey')


const elementsList = [$head1]

// console.log($contunebot)

$continuebot.addEventListener('click',()=>{
    // $continuebot.style.display = 'none';
    // $head1.style.display = 'none';
    elementsList.forEach(element => {
        let anim = element.animate({opacity: 0}, 300)
        anim.onfinish = ev => {
            element.remove()
        }
    $parsebody.style.display = 'block'
    anim = $parsebody.animate({
        right:'20vw',
        top: "5%",
        left: '20vw',
        width:'60vw',
        height: '500px',
        background: 'transparent'
        // minwidth: '400px',

    }, 500)
    anim.onfinish = ev => {
        $parsebody.style.right = '20vw'
        $parsebody.style.top = "5%"
        $parsebody.style.left = '20vw'
        $parsebody.style.width ='60vw'
        $parsebody.style.height = '500px'
        $parsebody.style.background= 'transparent'
        $parsebody.style.boxShadow= '20px 20px 100px 10000px rgba(0,0,0,0.2)'
        $parsesurvey.style.opacity = 1;
        
        // anim = $parsebody.animate({
        //     boxShadow: '15px 15px 5px 0 rgba(0,0,0,0.2)',
        //     top:'calc(5% - 30px)',
        //     left:'calc(5vw - 30px)',
        //     // minwidth: '400px',
    
        // }, 300)
        // anim.onfinish = el =>{
        //     $parsebody.style.boxShadow= '15px 15px 5px 0 rgba(0,0,0,0.2)'
        //     $parsebody.style.top='calc(5% - 30px)'
        //     $parsebody.style.left='calc(5vw - 30px)'
        // }
        // $parsebody.style.minwidth = '400px'
    }
    });
})

// function onClick(){
//     alert('adadad')
// }