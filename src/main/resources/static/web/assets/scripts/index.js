setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                featuredEp: [],
                featuredAr: [],
                isLoading: false
            }
        },
        created() {
            this.getCurrent()
            this.getArFeatured()
            this.getEpFeatured()
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
            addEpFav(id) {
                axios.post(`/api/favorite/addEpFav`, `id=${id}`)
                    .then(res => {
                        this.backMsg = res.data
                        Swal.fire({
                            position: 'center',
                            icon: 'success',
                            title: `${this.backMsg}`,
                            showConfirmButton: false,
                            timer: 1500
                        })
                    }).catch(err => {
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
            getCurrent() {
                axios.get(`/api/getCurrent`)
                    .then(res => {
                        this.current = res.data
                    }).catch(err => console.log(err))
            },
            getArFeatured() {
                axios.get(`/api/archives/featured`)
                    .then(res => {
                        this.featuredAr = res.data
                    }).catch(err => console.log(err))
            },
            getEpFeatured() {
                axios.get(`/api/episodes/featured`)
                    .then(res => {
                        this.featuredEp = res.data.sort((a, b) => b.id - a.id)
                    }).catch(err => console.log(err))
            }
        },
        computed: {
        }
    }).mount("#app")
}, 1000)