
function pizzeList(){
	axios.get("http://localhost:8080/api/pizze").then((list) =>{
		console.log(list);
		document.getElementById("pizze_list").innerHTML = '';
		list.data.forEach(pizza => {
		document.getElementById("pizze_list").innerHTML += `<li><a href="detail.html?id=${pizza.id}">${pizza.name}</a></li> `;
		});
		document.getElementById("create_page").innerHTML += `<a href="create.html">vai a crea pizza</a>`;
	}).catch((list) =>{
	console.error("non si puo eseguire la pagina riprova dopo" , list);
	alert('Errore durante la connessione');
	}); 
}
pizzeList();