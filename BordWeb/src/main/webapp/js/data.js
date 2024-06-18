/**
 * data.js
 */

const myMembers = [
	{ id: 'user01', name: '홍길동', phone: '010-1111-2222', point: 90 },
	{ id: 'user02', name: '박성민', phone: '010-2222-3333', point: 95 },
	{ id: 'user03', name: '성춘향', phone: '010-3333-4444', point: 120 }
];

const json = `[{"id":1,"first_name":"Drucy","last_name":"Corre","email":"dcorre0@purevolume.com","gender":"Female","salary":7622},
{"id":2,"first_name":"Lauretta","last_name":"Hatch","email":"lhatch1@census.gov","gender":"Female","salary":6851},
{"id":3,"first_name":"Barb","last_name":"Ketts","email":"bketts2@alibaba.com","gender":"Female","salary":3369},
{"id":4,"first_name":"Justen","last_name":"Rosnau","email":"jrosnau3@dropbox.com","gender":"Male","salary":5243},
{"id":5,"first_name":"Remington","last_name":"Vittet","email":"rvittet4@feedburner.com","gender":"Male","salary":3925},
{"id":6,"first_name":"Sharline","last_name":"Gabbatt","email":"sgabbatt5@unblog.fr","gender":"Female","salary":7112},
{"id":7,"first_name":"Jeremiah","last_name":"Garaghan","email":"jgaraghan6@list-manage.com","gender":"Male","salary":6117},
{"id":8,"first_name":"Ema","last_name":"Balham","email":"ebalham7@sakura.ne.jp","gender":"Female","salary":7470},
{"id":9,"first_name":"Corabel","last_name":"Matijasevic","email":"cmatijasevic8@devhub.com","gender":"Female","salary":5113},
{"id":10,"first_name":"Rickie","last_name":"Skedgell","email":"rskedgell9@dyndns.org","gender":"Male","salary":5510},
{"id":11,"first_name":"Leslie","last_name":"Spain","email":"lspaina@twitpic.com","gender":"Male","salary":4810},
{"id":12,"first_name":"Jarrid","last_name":"Falloon","email":"jfalloonb@topsy.com","gender":"Male","salary":3340},
{"id":13,"first_name":"Edd","last_name":"Crusham","email":"ecrushamc@fda.gov","gender":"Male","salary":7680},
{"id":14,"first_name":"Durante","last_name":"Drees","email":"ddreesd@army.mil","gender":"Male","salary":6860},
{"id":15,"first_name":"Lyndell","last_name":"Raoult","email":"lraoulte@gov.uk","gender":"Female","salary":4093}]`;

const employees = JSON.parse(json);