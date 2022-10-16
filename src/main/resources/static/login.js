//console.log("register page");
//import * as member from "./member_module.js";

//let submit_button=document.querySelector("#submit_button");
let switch_button=document.querySelector("#switch_button");

//submit_button.addEventListener("click", ()=>{
//	let input_account=document.querySelector("#exampleInputEmail1");
//	let input_password=document.querySelector("#exampleInputPassword1");
//	console.log(input_account.value);
//	console.log(input_password.value);
//	member.sign_in(input_account.value, input_password.value).then(resp => {
//		console.log(resp);
//		if(resp.error){
//			let email_message=document.querySelector("#email_message");
//			email_message.textContent=resp.message;
//			email_message.style.display="block";
//			return;
//		}
//		let email_message=document.querySelector("#email_message");
//		email_message.textContent="登入成功";
//		email_message.style.display="block";
//	})
//})

switch_button.addEventListener("click", ()=>{
	console.log("switch!");
	 location.href="http://localhost:5050/register";
//	location.href="https://springbootpractice.yin888.info/register";
})

//let patch_button=document.querySelector("#patch");
//let delete_button=document.querySelector("#delete");

//patch_button.addEventListener("click", ()=>{
//	member.patch_test().then(resp=>{
//		console.log(resp);
//	})
//})
//
//delete_button.addEventListener("click", ()=>{
//	member.delete_test().then(resp=>{
//		console.log(resp);
//	})
//})

//submit_button.addEventListener("click", ()=>{
//	let input_account=document.querySelector("#exampleInputEmail1");
//	let input_password=document.querySelector("#exampleInputPassword1");
//	console.log("post /login");
//	console.log(input_account.value);
//	console.log(input_password.value);
//	member.sign_in_spring_security(input_account.value, input_password.value).then(resp => {
//		console.log(resp);
//		if(resp.error){
//			let email_message=document.querySelector("#email_message");
//			email_message.textContent=resp.message;
//			email_message.style.display="block";
//			return;
//		}
//		let email_message=document.querySelector("#email_message");
//		email_message.textContent="登入成功";
//		email_message.style.display="block";
//	})
//})


