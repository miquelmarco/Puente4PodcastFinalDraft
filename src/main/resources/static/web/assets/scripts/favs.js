setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                //data
                current: [],
                favsEp: [],
                favsAr: [],
                //others
                isLoading: false,
                backMsg: ''
            }
        },
        created() {
            this.getCurrent()
            this.getFavs()
        },
        methods: {
            getCurrent() {
                axios.get(`/api/getCurrent`)
                    .then(res => {
                        this.current = res.data
                    }).catch(err => console.log(err))
            },
            getFavs() {
                axios.get(`/api/episodes/favs`)
                    .then(res => {
                        this.favsEp = res.data
                        console.log(this.favsEp)
                    }).catch(err => {
                        console.log(err)
                    })
            },
            deleteFav(arId) {
                axios.delete(`/api/favorite/removeEpFav`, {
                    params:{
                        id: arId
                    }
                })
                    .then(res => {
                        this.backMsg = res.data
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: `${this.backMsg}`,
                            showConfirmButton: false,
                            timer: 1500
                        })
                        setTimeout(() => {
                            location.reload()
                        }, 1600)
                    }).catch(err => {
                        console.log(err)
                        this.backMsg = err.response.data
                        console.log(err.response.data)
                        Swal.fire({
                            position: 'center',
                            icon: 'error',
                            title: `${this.backMsg}`,
                            showConfirmButton: false,
                            timer: 1500
                        })
                    })
            },
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
            }
        },
        computed: {

        }
    }).mount("#app")
}, 1000)