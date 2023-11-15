setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                //data
                current: [],

                //others
                isLoading: false
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
            }
        },
        computed: {
            
        }
    }).mount("#app")
}, 1000)