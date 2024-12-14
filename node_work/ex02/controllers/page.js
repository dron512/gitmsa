exports.renderProfile = (req, res) => {
    res.render('profile', {title: '내정보 PMH'});
}
exports.renderJoin = (req, res) => {
    res.render('join', {title: '회원가입 PMH'});
}
exports.renderMain = (req, res) => {
    const twits = []
    res.render('main', {title: 'PMH', twits});
}