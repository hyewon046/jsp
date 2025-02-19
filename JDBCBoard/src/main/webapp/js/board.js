const board = {
	getReplyList : function (aid, ss_mid){
		axios.get('/selectReply.do?aid='+aid).then(
			response => {
				this.printReplyList(response.data, ss_mid);
		
			}
		)
	},
	deleteReply : function(rid, aid, ss_mid) {
		axios.get('/deleteReply.do?rid='+rid).then(
			() => this.getReplyList(aid, ss_mid)
		); 
	},
	printReplyList  : function(data, ss_mid) {
		if (data)  {
			let ulHtml = '';
			for (reply of data) {
				const dateStr = `${reply.rregdate}`;
				const datePrintStr = dayjs(dateStr).format('HH:mm');
				ulHtml += `<li>(${reply.mid})&nbsp;[${datePrintStr}]&nbsp; ${reply.rcontent}`;
				if (ss_mid == `${reply.mid}`) {
				ulHtml += `&nbsp;<a href="javascript:board.deleteReply('${reply.rid}','${reply.aid}','${ss_mid}');">[삭제]</a></li>`}
			}
			$('#replyList').html(ulHtml);
		}
	},
	insertReply : function(ss_mid) {
		const insertReplyBtn = document.querySelector("#insertReplyBtn");
		axios.post('/insertReply.do', 
			{
			rcontent: $('input[name="rcontent"]').val(),
			mid:insertReplyBtn.dataset.mid,
			aid:insertReplyBtn.dataset.aid
			}, {
				headers: {
					'Content-Type': 'application/json'
				}
			}).then(
				response => {
					this.getReplyList(insertReplyBtn.dataset.aid, ss_mid);
			}
		);
	},
	getBoardList : function() {
		axios.get('/selectBoardJson.do').then(
			response => {
				this.printBoardList(response.data);
			}
		);
	},
	printBoardList: function(data) {
		if(data) {
			let selectHtml='';
			for (brd of data) {
				selectHtml += `<option value='${brd.bid}'>${brd.bname}</option>`;
			}
			$("select[name='searchBoard']").html(
				"<option value=''>전체</option>" + selectHtml
			);
		}
	}
};

const check = {
	checkLogin: function(mid) {
		if(mid) return true;
		else {
			alert('회원 전용 서비스입니다!');
			return false;
		}
	}
};

$('#insertBtn').click(e => {
	if(check.checkLogin(e.target.dataset.mid)) {
		location.href=e.target.dataset.location;
	}
});

$('#insertReplyBtn').click(e => {
	board.insertReply(e.target.dataset.mid);
});

