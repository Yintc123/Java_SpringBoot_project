console.log("register page");
import * as member from "./member_module.js";

let submit_button=document.querySelector("#submit_button");
let switch_button=document.querySelector("#switch_button");

submit_button.addEventListener("click", ()=>{
	let input_name=document.querySelector("#exampleInputName");
	let input_account=document.querySelector("#exampleInputEmail1");
	let input_password=document.querySelector("#exampleInputPassword1");
	console.log(input_account.value);
	console.log(input_password.value);
	member.sign_up(input_name.value, input_account.value, input_password.value).then(resp => {
		console.log(resp);
		if (resp.error){
			let email_message=document.querySelector("#email_message");
			email_message.textContent=resp.message;
			email_message.style.display="block";
			return;
		}
		// location.href="http://localhost:5050/login";
		location.href="https://springbootpractice.yin888.info/login";
	})
})

switch_button.addEventListener("click", ()=>{
	console.log("switch!");
	// location.href="http://localhost:5050/login";
	location.href="https://springbootpractice.yin888.info/login";
})

let patch_button=document.querySelector("#patch");
let delete_button=document.querySelector("#delete");

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

