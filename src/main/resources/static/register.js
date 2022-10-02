console.log("register page");
import * as member from "./member_module.js";

let submit_button=document.querySelector("#submit_button");

submit_button.addEventListener("click", ()=>{
	let input_account=document.querySelector("#exampleInputEmail1");
	let input_password=document.querySelector("#exampleInputPassword1");
	console.log(input_account.value);
	console.log(input_password.value);
	member.sign_in(input_account.value, input_password.value).then(resp => {
		console.log(resp);
	})
})

let patch_button=document.querySelector("#patch");
let delete_button=document.querySelector("#delete");

patch_button.addEventListener("click", ()=>{
	member.patch_test().then(resp=>{
		console.log(resp);
	})
})

delete_button.addEventListener("click", ()=>{
	member.delete_test().then(resp=>{
		console.log(resp);
	})
})

