
const URLParams=new URLSearchParams(window.location.search);
const pizzeId=URLParams.get('id');

axios.get(`http://localhost:8080/api/pizze/${pizzeId}`).then((list) => {
    console.log( list);
   
    document.querySelector('#name').innerHTML= list.data.name;
    document.querySelector('#description').innerHTML= list.data.description;
    document.querySelector('#img').innerHTML= list.data.img;
    document.querySelector('#price').innerHTML= list.data.price;
    
    document.getElementById("home_page").innerHTML += `<a href="index.html">vai a home</a>`;
}).catch((list) =>{
	console.error("non si puo eseguire la pagina riprova dopo" , list);
	alert('Errore durante la connessione');
	}); 