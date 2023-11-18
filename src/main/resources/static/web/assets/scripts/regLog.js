setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                firstName: '',
                lastName: '',
                userName: '',
                mail: '',
                nacionality: '',
                password: '',
                passwordConfirm: '',
                isLoading: false,
                mailLog: '',
                passwordLog: ''
            }
        },
        created() {
            this.getCurrent()
        },
    methods: {
        logOut() {
            axios.post("/api/logout")
                .then(res => {
                    if (res.status == 200) {
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: 'Bye bye!',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        setTimeout(() => {
                            window.location.href = "/web/index.html";
                        }, 1800)
                    }
                    console.log(res)
                }).catch(err => {
                    Swal.fire({
                        position: 'center',
                        title: 'Cant log out, try again!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                })
        },
        getCurrent(){
            axios.get(`/api/getCurrent`)
            .then(res => {
                this.current = res.data
                console.log(this.current)
            }).catch(err => console.log(err))
        },
        register(){
            if(this.firstName &&
                this.lastName &&
                this.userName &&
                this.mail &&
                this.nacionality &&
                this.password) {
                    if(this.password === this.passwordConfirm) {
                        axios.post(`/api/register`, `firstName=${this.firstName}&lastName=${this.lastName}&userName=${this.userName}&mail=${this.mail}&nacionality=${this.nacionality}&password=${this.password}`,
                        { headers: { 'content-type': 'application/x-www-form-urlencoded' } }
                        ).then(res => {
                            console.log(res)
                        }).catch(err => {
                            console.log(err)
                        })
                    }
                } else {
                    return console.log("Completa todos los datos")
                }
        },
        login() {
            if(this.mailLog && this.passwordLog) {
                axios.post("/api/login", `mail=${this.mailLog}&password=${this.passwordLog}`)
                .then(res => {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Ingresando...',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    setTimeout(() => {
                        location.href = `/web/index.html`
                    },1600)
                }).catch(err => {
                    console.log(err)
                })
            }
        }
    },
    computed: {
        
    }
}).mount("#app")
},1000)