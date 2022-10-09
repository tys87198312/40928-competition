
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: 'Competition', component: () => import('pages/Competition.vue') },
      { path: 'CompetitionXS', component: () => import('pages/CompetitionXS.vue') },
      { path: 'CompetitionPW', component: () => import('pages/CompetitionPW.vue') },
      { path: 'CompetitionJoinXS', component: () => import('pages/CompetitionJoinXS.vue') },
      { path: 'CompetitionJoinPW', component: () => import('pages/CompetitionJoinPW.vue') },
      { path: 'UserManager', component: () => import('pages/UserManager.vue') }
    ]
  },
  {
    path: '/login',
    component: () => import('layouts/Login.vue'),
    children: []
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
