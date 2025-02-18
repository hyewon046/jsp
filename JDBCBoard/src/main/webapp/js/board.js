const board = {
	getReplyList : function (aid){
		axios.get('/selectReply.do?aid='+aid).then(
			response => {
				this.printReplyList(response.data);
		
			}
		)
	},
	deleteReply : function(rid, aid) {
		axios.get('/deleteReply.do?rid='+rid).then(
			() => this.getReplyList(aid)
		);
	},
	printReplyList  : function(data) {
		if (data)  {
			let ulHtml = '';
			for (reply of data) {
				const dateStr = `${reply.rregdate}`;
				const datePrintStr = dayjs(dateStr).format('HH:mm');
				ulHtml += `<li>(${reply.mid})&nbsp;[${datePrintStr}]&nbsp; ${reply.rcontent}`;
				ulHtml += `&nbsp;<a href="javascript:board.deleteReply('${reply.rid}','${reply.aid}');">[삭제]</a></li>`
			}
			$('#replyList').html(ulHtml);
		}
	}
};

