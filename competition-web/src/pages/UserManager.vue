<template>
  <div class="q-pa-md">
    <!--主体-->
    <q-table
      title="用户管理"
      :rows="rows"
      :columns="columns"
      color="primary"
      :pagination="myPagination"
      :visible-columns="visibleColumns"
      row-key="userId"
      selection="single"
      v-model:selected="selected"
    >
      <template v-slot:top-right>
        <div>
          <q-input borderless dense debounce="300" v-model="params.filter" placeholder="姓名">
            <template v-slot:append>
              <q-icon name="search" @click="dataList"/>
            </template>
          </q-input>
          <div class="q-pt-lg" style="display: flex; flex-direction: row">
            <div class="q-px-md">
              <q-btn
                color="primary"
                label="新增"
                size="md"
                no-caps
                @click="add"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="primary"
                label="修改"
                size="md"
                no-caps
                @click="update"
              />
            </div>
            <div class="q-px-md">
              <q-btn
                class="q-px-md"
                color="red"
                label="删除"
                size="md"
                no-caps
                @click="del"
              />
            </div>
          </div>
        </div>
      </template>
    </q-table>
  </div>


  <!--diag-->
  <q-dialog v-model="dialogOpen"  transition-show="rotate" transition-hide="rotate">
    <q-card style="width: 800px; height: 500px; display: flex; flex-direction: column; justify-content: space-between">
      <q-card-section>
        <div class="text-h6">{{opt == 'add' ? '新增': '修改'}}用户</div>
      </q-card-section>

      <q-card-section class="q-gutter-md">
        <q-input filled label="姓名" v-model="user.name"></q-input>
        <q-input filled label="账号" v-model="user.username"></q-input>
        <q-select filled v-model="user.roleName" :options="options" label="角色" />
        <q-input filled type="tel" label="电话号码" v-model="user.phone"></q-input>
        <q-input filled type="email" label="电子邮箱" v-model="user.email"></q-input>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn  label="取消" color="primary" v-close-popup  />
        <q-btn  label="提交" color="primary" @click="submitForm" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>

<script>
  import { useQuasar } from 'quasar'
  import { useCounterStore } from 'stores/global';
  const store = useCounterStore();
  const columns = [
    {
      name: 'userId',
      label: 'USERID',
      align: 'center',
      field: row => row.userId,
      format: val => `${val}`
    },
    {
      name: 'name',
      label: '姓名',
      align: 'center',
      field: row => row.name,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'username',
      label: '账号',
      align: 'center',
      field: row => row.username,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'roleName',
      label: '角色',
      align: 'center',
      field: row => row.roleName,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'phone',
      label: '电话号码',
      align: 'center',
      field: row => row.phone,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'email',
      label: '电子邮箱',
      align: 'center',
      field: row => row.email,
      format: val => `${val}`,
      sortable: true
    },
    {
      name: 'createTime',
      label: '创建时间',
      align: 'center',
      field: row => row.createTime,
      format: val => `${val}`,
      sortable: true
    }
  ]
  const myPagination = {
    sortBy: 'createTime',
    descending: true,
    rowsPerPage: 10
  }
  export default {
    name: 'UserManageer',
    data () {
      return {
        myPagination: myPagination,
        rows: [],
        columns: columns,
        visibleColumns: ['name','username','phone','email','createTime', 'roleName'],
        options: ['主办方', '观众', '选手', '评委', '系统管理员'],
        selected: [],
        dialogOpen: false,
        opt: 'add',
        params: {
          rowsPerPage: 10,
          page: 0,
          filter: ''
        },
        user: {
          userId: null,
          username: '',
          name: '',
          phone: null,
          email: null,
          roleName: ''
        }
      }
    },
    mounted() {
      this.dataList()
    },
    methods: {
      dataList () {
        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.get('sys/user/list', {
          params: this.params
        }).then((response) => {
          let result = response.data
          /*结果校验*/
          if (result.code != '200') {
            this.$q.notify({
              message: result.msg,
              color: 'red',
              position: 'top'
            })
            return
          }
          this.rows = result.data.list
        })
      },
      add () {
        this.opt = 'add'
        this.user.username = null
        this.user.name = null
        this.user.phone = null
        this.user.email = null
        this.user.roleName = null
        this.user.userId = null

        this.dialogOpen = true
      },
      update () {
        if (this.selected.length == 0) {
          this.$q.notify({
            message: '请先选中一条数据',
            color: 'warning',
            position: 'top'
          })
        } else {
          this.opt = 'update'
          this.user.username = this.selected[0].username
          this.user.name = this.selected[0].name
          this.user.phone = this.selected[0].phone
          this.user.email = this.selected[0].email
          this.user.roleName = this.selected[0].roleName
          this.user.userId = this.selected[0].userId

          this.dialogOpen = true
        }
      },
      del () {
        if (this.selected.length == 0) {
          this.$q.notify({
            message: '请先选中一条数据',
            color: 'warning',
            position: 'top'
          })
        } else {
          this.$q.notify({
            message: '确认删除已选中数据吗',
            color: 'primary',
            actions: [
              { label: '确认', color: 'yellow', handler: () => {
                  this.$api.defaults.headers.common['Authorization'] = store.user.token
                  this.$api.get('sys/user/delete-by-id', {
                    params: {
                      userId: this.selected[0].userId
                    }
                  }).then((response) => {
                    let result = response.data
                    /*结果校验*/
                    if (result.code != '200') {
                      this.$q.notify({
                        message: result.msg,
                        color: 'red',
                        position: 'top'
                      })
                      return
                    }
                    this.$q.notify({
                      message: '操作成功',
                      color: 'primary',
                      position: 'top'
                    })

                      this.dataList()
                  })
                } },
              { label: '取消', color: 'white', handler: () => {

                } }
            ],
            position: 'center'
          })
        }
      },
      submitForm () {
        this.$api.defaults.headers.common['Authorization'] = store.user.token
        this.$api.post('sys/user/saveOrUpdate', this.user)
          .then((response) => {
            let result = response.data
            /*结果校验*/
            if (result.code != '200') {
              this.$q.notify({
                message: result.msg,
                color: 'red',
                position: 'top'
              })
              return
            }

            this.dataList()
            this.dialogOpen = false

            this.$q.notify({
              message: result.msg,
              color: 'primary',
              position: 'top'
            })
          })
      }
    }
  }
</script>
