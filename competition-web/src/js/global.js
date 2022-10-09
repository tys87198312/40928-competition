let user = {
  userId: null,
  userName: null,
  token: null
}

function resetUser () {
  user.userId = null
  user.userName = null
  user.token = null
}
function setUser (userId, userName, token) {
  user.userId = userId
  user.userName = userName
  user.token = token
}

export default {
  user,
  resetUser,
  setUser
}
