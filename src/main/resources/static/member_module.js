const url="http://localhost:5050/member";

export async function sign_in(account, password){
	let form=new FormData();
	const member_data=[account, password];
	const query_string=["account", "password"];
	for(let i=0; i < member_data.length ; i++){
		form.append(query_string[i], member_data[i]);
	}
	return fetch(url, {
		method:"POST",
		body:form
	}).then(response => {
		return response.json();
	})
}