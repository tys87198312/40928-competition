import { defineStore } from 'pinia';

export const useCounterStore = defineStore('global', {
  state: () => ({
    user: {
      userId: null,
      userName: null,
      token: null,
      roleName: null,
      name: null
    }
  }),
  getters: {
    //getUserId: () => this.user.userId
  },
  actions: {
    getUser() {
      return this.user
    },
    getUserId() {
      return this.user.userId
    },
  },
});
