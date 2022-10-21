console.log("hello from js");

let orders_button=document.querySelector("#orders_button");
let stock_button=document.querySelector("#stock_button");
let tour_button=document.querySelector("#tour_button");
let mb_button=document.querySelector("#mb_button");

let flag_stock_project=0;
stock_button.addEventListener("click", ()=>{
	let p_stock=document.querySelectorAll(".stock_hide");
	//console.log(p_stock);
	let status="block";
	if(flag_stock_project != 0){
		status="none";
		flag_stock_project = 0;
	}else{
		flag_stock_project = 1;
	}
	for(let i=0;i<p_stock.length;i++){
		p_stock[i].style.display=status;
	}
})

let flag_tour_project=0;
tour_button.addEventListener("click", ()=>{
	let p_stock=document.querySelectorAll(".tour_hide");
	//console.log(p_stock);
	let status="block";
	if(flag_tour_project != 0){
		status="none";
		flag_tour_project = 0;
	}else{
		flag_tour_project = 1;
	}
	for(let i=0;i<p_stock.length;i++){
		p_stock[i].style.display=status;
	}
})

let flag_mb_project=0;
mb_button.addEventListener("click", ()=>{
	let p_stock=document.querySelectorAll(".mb_hide");
	//console.log(p_stock);
	let status="block";
	if(flag_mb_project != 0){
		status="none";
		flag_mb_project = 0;
	}else{
		flag_mb_project = 1;
	}
	for(let i=0;i<p_stock.length;i++){
		p_stock[i].style.display=status;
	}
})

let flag_orders_project=0;
orders_button.addEventListener("click", ()=>{
	let p_stock=document.querySelectorAll(".orders_hide");
	//console.log(p_stock);
	let status="block";
	if(flag_orders_project != 0){
		status="none";
		flag_orders_project = 0;
	}else{
		flag_orders_project = 1;
	}
	for(let i=0;i<p_stock.length;i++){
		p_stock[i].style.display=status;
	}
})


